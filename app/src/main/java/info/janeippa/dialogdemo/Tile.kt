package info.janeippa.dialogdemo

class Tile {
    var imageId: Int = R.drawable.dummy
    var sectionName: String = ""

    var hasTile = false
        get() = imageId != R.drawable.dummy

    var isSection = false
        get() = sectionName.isNotEmpty()
}