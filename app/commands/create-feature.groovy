description('Creates a new profile Feature') {
    usage 'grace create-feature [Feature Name]'
    argument name: 'Feature Name', description: 'The name of the Feature', required: true
}

if (args) {
    def fn = args[0].trim()
    def dir = file("features/${fn}").canonicalPath

    render('''
# customize configuration here
# my:
#   setting: true
#''', file("features/${fn}/skeleton/app/conf/application.yml"))

    render('''
description: Description of the feature
# customize versions here
# dependencies:
#   compile:
#     - "org.graceframework.plugins:myplugin:1.0"
#''', file("features/${fn}/feature.yml"))

    console.addStatus "Feature created at ${projectPath(dir)}"
}
else {
    error 'No feature name specified'
}
