package hu.bdz.grabber.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import hu.bdz.grabber.adapter.ListRecyclerAdapter
import hu.bdz.grabber.databinding.FragmentAddBinding
import hu.bdz.grabber.model.ListItem
import kotlin.random.Random

class AddFragmet(val adapter: ListRecyclerAdapter, val listViewModel: ListViewModel): DialogFragment()
{
    private lateinit var binding: FragmentAddBinding

    companion object {
        const val TAG = "AddItemDialog"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentAddBinding.inflate(inflater, container, false)
        dialog?.setTitle("Hozzáadás")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddItem.setOnClickListener {
            val newItem = ListItem(1, binding.etItemName.text.toString())
            //adapter.addItem(newItem)
            listViewModel.insert(newItem)
            adapter.notifyItemInserted(listViewModel.itemCount-1)
            dismiss()
        }

        binding.btnCancelAddItem.setOnClickListener {
            dismiss()
        }
    }
}