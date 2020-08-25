from rubicon.java import JavaClass

Identifier = JavaClass("io/github/nylonmc/content/wrapper/IdentifierWrapper")
Item = JavaClass("io/github/nylonmc/content/wrapper/ItemWrapper")
ItemSettings = JavaClass("io/github/nylonmc/content/proxy/ItemSettingsProxy")
_ItemGroupsClass = JavaClass("io/github/nylonmc/content/proxy/ItemGroupProxy")
ItemGroups = _ItemGroupsClass()
_RegistryClass = JavaClass("io/github/nylonmc/content/proxy/RegistryProxy")
Registry = _RegistryClass()