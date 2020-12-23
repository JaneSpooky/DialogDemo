package info.janeippa.dialogdemo.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import info.janeippa.dialogdemo.R
import info.janeippa.dialogdemo.TextImageData
import info.janeippa.dialogdemo.Tile

@BindingAdapter("android:src")
fun ImageView.setImageResource(imageId: Int?) {
    Picasso.get().load(imageId ?: R.drawable.dummy).into(this)
}

@BindingAdapter("textImageData")
fun ImageView.setTextImageData(textImageData: TextImageData?) {
    Picasso.get().load(textImageData?.imageId ?: R.drawable.dummy).into(this)
}

@BindingAdapter("tileImage")
fun ImageView.setTileImage(tile: Tile?) {
    Picasso.get().load(tile?.imageId ?: R.drawable.dummy).into(this)
}