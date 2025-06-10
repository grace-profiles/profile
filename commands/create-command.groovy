description( "Creates a new Command for the profile" ) {
  usage "grace create-command [Command Name]"
  argument name:'Command Name', description:"The name of the Command", required:true
  flag name:'force', description:"Whether to overwrite existing files"
}

if(args) {
	def scriptName = GrailsNameUtils.getClassNameForLowerCaseHyphenSeparatedName(args[0])
	def model = model( scriptName )
    render template:'commands/Command.groovy',
		   destination:file("commands/${model.lowerCaseName}.groovy"),
		   model: model,
		   overwrite: flag('force')

}
else {
    error "No command name specified"
}
