WORKSPACE_DIR = File.expand_path(File.dirname(__FILE__) + '/..')

def in_dir(dir)
  current = Dir.pwd
  begin
    Dir.chdir(dir)
    yield
  ensure
    Dir.chdir(current)
  end
end

SITE_DIR = "#{WORKSPACE_DIR}/reports/site"

desc 'Build the part of the website for this branch'
task 'site:build' do
  project = Buildr.project('react4j-webspeechdemo')
  rm_rf SITE_DIR
  mkdir_p SITE_DIR

  cp_r Dir["#{project._('docs')}/*"], SITE_DIR

  %w(react4j.webspeechdemo.WebSpeechDemoDev react4j.webspeechdemo.WebSpeechDemoProd).each do |dir|
    output_dir = project._(:target, :generated, :gwt, dir)
    file(output_dir).invoke
    cp_r Dir["#{output_dir}/*"], SITE_DIR
    rm_f Dir["#{SITE_DIR}/**/*.devmode.js"]
    rm_f Dir["#{SITE_DIR}/**/compilation-mappings.txt"]
    rm_rf "#{SITE_DIR}/WEB-INF"
  end
end

desc 'Build the website'
task 'site:deploy' => ['site:build'] do
  origin_url = 'https://github.com/react4j/react4j.github.io.git'

  travis_build_number = ENV['TRAVIS_BUILD_NUMBER']
  if travis_build_number
    origin_url = origin_url.gsub('https://github.com/', 'git@github.com:')
  end

  local_dir = "#{WORKSPACE_DIR}/target/remote_site"
  rm_rf local_dir

  sh "git clone -b master --depth 1 #{origin_url} #{local_dir}"

  in_dir(local_dir) do
    message ="Update WebSpeechDemo website#{travis_build_number.nil? ? '' : " - Travis build: #{travis_build_number}"}"

    rm_rf "#{local_dir}/webspeechdemo"
    mkdir_p "#{local_dir}/webspeechdemo"
    cp_r Dir["#{SITE_DIR}/webspeechdemo"], "#{local_dir}/webspeechdemo"
    sh 'git add . -f'
    puts `git commit -m "#{message}"`
    if 0 == $?.exitstatus
      sh 'git push -f origin master'
    end
  end
end

desc 'Publish the website if build is on candidate branch'
task 'site:deploy_if_candidate_branch' do
  branch = ENV['TRAVIS_BRANCH']
  if branch.nil? || %w(master).include?(branch)
    ENV['SITE_BRANCH'] = branch
    puts "Deploying site for branch '#{branch}'"
    task('site:deploy').invoke
  else
    puts "Site deploy skipped as branch '#{branch}' is not in the candidate set"
  end
end
