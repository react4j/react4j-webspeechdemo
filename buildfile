require 'buildr/git_auto_version'
require 'buildr/gwt'

desc 'React4j WebSpeech Demos'
define 'react4j-webspeechdemos' do
  project.group = 'org.realityforge.react4j.webspeechdemos'
  compile.options.source = '1.8'
  compile.options.target = '1.8'
  compile.options.lint = 'all,-processing,-serial'
  project.compile.options.warnings = true
  project.compile.options.other = %w(-Werror -Xmaxerrs 10000 -Xmaxwarns 10000)

  project.version = ENV['PRODUCT_VERSION'] if ENV['PRODUCT_VERSION']

  project.processorpath << :react4j_processor
  project.processorpath << :arez_processor

  compile.with :javax_annotation,
               :jetbrains_annotations,
               :jsinterop_base,
               :jsinterop_annotations,
               :elemental2_core,
               :elemental2_dom,
               :elemental2_promise,
               :braincheck,
               :grim_annotations,
               :react4j_core,
               :react4j_dom,
               :arez_core,
               :arez_spytools,
               :gwt_user

  # Exclude the Dev module if EXCLUDE_GWT_DEV_MODULE is true
  GWT_MODULES = %w(react4j.webspeechdemos.WebSpeechDemoProd) + (ENV['EXCLUDE_GWT_DEV_MODULE'] == 'true' ? [] : %w(react4j.webspeechdemos.WebSpeechDemoDev))
  gwt_enhance(project,
              :modules_complete => true,
              :package_jars => false,
              :gwt_modules => GWT_MODULES,
              :module_gwtc_args => {
                'react4j.webspeechdemos.WebSpeechDemoDev' => %w(-optimize 9 -checkAssertions -XmethodNameDisplayMode FULL -noincremental),
                'react4j.webspeechdemos.WebSpeechDemoProd' => %w(-XdisableClassMetadata -XdisableCastChecking -optimize 9 -nocheckAssertions -XmethodNameDisplayMode NONE -noincremental -compileReport)
              })

  iml.excluded_directories << project._('tmp')

  ipr.add_component_from_artifact(:idea_codestyle)

  ipr.add_gwt_configuration(project,
                            :gwt_module => 'react4j.webspeechdemos.WebSpeechDemoDev',
                            :start_javascript_debugger => false,
                            :open_in_browser => false,
                            :vm_parameters => '-Xmx2G',
                            :shell_parameters => "-strict -style PRETTY -XmethodNameDisplayMode FULL -nostartServer -incremental -codeServerPort 8889 -bindAddress 0.0.0.0 -deploy #{_(:generated, :gwt, 'deploy')} -extra #{_(:generated, :gwt, 'extra')} -war #{_(:generated, :gwt, 'war')}",
                            :launch_page => 'http://127.0.0.1:8889/webspeechdemos/index.html')
end
