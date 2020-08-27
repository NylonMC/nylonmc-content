from rubicon.java import JavaClass
import nylonmc.content.minecraft as mc

ItemWrapperData = JavaClass("io/github/nylonmc/content/wrapper/datatransfer/ItemWrapperData")
ItemWrapperData.itemWrapper.updateIItem(mc._id_to_iitem[ItemWrapperData.itemWrapper.getNumericalId()])
ItemWrapperData.thingToDo.run()