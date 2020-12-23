package info.janeippa.dialogdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.ItemListener
import com.afollestad.materialdialogs.list.listItems
import info.janeippa.dialogdemo.databinding.MainActivityBinding
import info.janeippa.dialogdemo.databinding.SelectImageDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    private fun initialize() {
        initBinding()
        initLayout()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        binding.apply {
            lifecycleOwner = this@MainActivity
            textImageData = viewModel.textImageData
        }
    }

    private fun initLayout() {
        binding.apply {
            selectActionButton.setOnClickListener {
                showSelectActionDialog()
            }
            selectImageButton.setOnClickListener {
                showSelectImageDialog()
            }
        }
    }

    private fun showSelectActionDialog() {
        MaterialDialog(this).show {
            cancelable(false)
            title(R.string.select_action_dialog_title)
            listItems(R.array.actions, selection = object: ItemListener {
                override fun invoke(dialog: MaterialDialog, index: Int, text: CharSequence) {
                    viewModel.setText("$text")
                    dismiss()
                }
            })
        }
    }

    private fun showSelectImageDialog() {
        MaterialDialog(this).show {
            cancelable(false)
            title(R.string.select_action_dialog_title)
            val binding = SelectImageDialogBinding.inflate(LayoutInflater.from(this@MainActivity), null, false)
            binding.apply {
                tilesView.customAdapter.apply {
                    refresh(viewModel.getTiles())
                }
                closeButton.setOnClickListener {
                    dismiss()
                }
            }
            setContentView(binding.root)
        }
    }
}