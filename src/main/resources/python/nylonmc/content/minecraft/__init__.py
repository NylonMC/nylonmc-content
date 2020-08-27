from rubicon.java import JavaClass, JavaInterface

Identifier = JavaClass("io/github/nylonmc/content/wrapper/IdentifierWrapper")
_ItemWrapper = JavaClass("io/github/nylonmc/content/wrapper/ItemWrapper")
_IItem = JavaInterface("io/github/nylonmc/content/interfaces/IItem")
class Item(_IItem):
    _settings = None
    def __init__(self, settings):
        super().__init__()
        self._settings = settings
    def onUse(self, world, user, hand, return_value):
        #Equivelent To Item.use
        pass
    def getSettings(self, return_value):
        return_value.set(self._settings)
ItemSettings = JavaClass("io/github/nylonmc/content/proxy/ItemSettingsProxy")
_ItemGroupsClass = JavaClass("io/github/nylonmc/content/proxy/ItemGroupProxy")
ItemGroups = _ItemGroupsClass()
_JRegistryClass = JavaClass("io/github/nylonmc/content/proxy/RegistryProxy")
_JRegistry = _JRegistryClass()
_id_to_iitem = dict()
class _Registry:
    def register_item(self, id, item):
        item_wrapper = _ItemWrapper(item)
        _JRegistry.register(_JRegistry.getItemRegistry(), id, item_wrapper)
        _id_to_iitem[item_wrapper.getNumericalId()] = item
registry = _Registry()
ActionResult = JavaClass("io/github/nylonmc/content/proxy/ActionResultProxy")