from rubicon.java import JavaClass, JavaInterface

_NylonClientCommands = JavaClass("io/github/nylonmc/content/NylonClientCommands")
def register(builder):
    _NylonClientCommands.register(builder)
ArgumentBuilders = JavaClass("io/github/cottonmc/clientcommands/ArgumentBuilders")
Command = JavaInterface("com/mojang/brigadier/Command")