package info.janeippa.dialogdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.janeippa.dialogdemo.DialogDemoApplication.Companion.applicationContext

class MainViewModel: ViewModel() {

    val textImageData = TextImageData()
    val selectedTile = MutableLiveData<Tile>()

    fun setText(text: String) {
        textImageData.text = text
    }

    fun setImageId(imageId: Int) {
        textImageData.imageId = imageId
    }

    fun getTiles(): List<Tile> {
        val sectionNames = mutableListOf(R.string.manzu, R.string.souzu, R.string.pinzu, R.string.jihai)
        return IMAGE_IDS.map {
            Tile().apply {
                if (it == R.drawable.dummy && sectionNames.isNotEmpty())
                    sectionName = applicationContext.getString(sectionNames.removeAt(0))
                else
                    imageId = it
            }
        }
    }

    fun selectTile(tile: Tile) {
        selectedTile.postValue(tile)
        textImageData.imageId = tile.imageId
    }

    companion object {
        val IMAGE_IDS = listOf(R.drawable.dummy, R.drawable.man1, R.drawable.man2, R.drawable.man3, R.drawable.man4, R.drawable.man5, R.drawable.man5r, R.drawable.man6, R.drawable.man7, R.drawable.man8, R.drawable.man9, R.drawable.dummy, R.drawable.sou1, R.drawable.sou2, R.drawable.sou3, R.drawable.sou4, R.drawable.sou5, R.drawable.sou5r, R.drawable.sou6, R.drawable.sou7, R.drawable.sou8, R.drawable.sou9, R.drawable.dummy, R.drawable.pin1, R.drawable.pin2, R.drawable.pin3, R.drawable.pin4, R.drawable.pin5, R.drawable.pin5r, R.drawable.pin6, R.drawable.pin7, R.drawable.pin8, R.drawable.pin9, R.drawable.dummy, R.drawable.ji1, R.drawable.ji2, R.drawable.ji3, R.drawable.ji4, R.drawable.ji5, R.drawable.ji6, R.drawable.ji7)
    }
}