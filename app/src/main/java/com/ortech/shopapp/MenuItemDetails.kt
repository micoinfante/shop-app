package com.ortech.shopapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ortech.shopapp.Adapters.BranchDetailsAdapter
import com.ortech.shopapp.Adapters.MenuItemDetailsAdapter
import com.ortech.shopapp.Models.MenuList
import com.ortech.shopapp.Views.HeaderItemDecoration
import kotlinx.android.synthetic.main.fragment_branch_details.*
import kotlinx.android.synthetic.main.fragment_menu_item_details.*

private const val ARG_MENU_ITEM = "menu_item"

class MenuItemDetails : Fragment() {

  private var menuItem: MenuList? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      menuItem = it.getSerializable(ARG_MENU_ITEM) as? MenuList
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_menu_item_details, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setup()
    setupToolBar()
  }

  private fun setup() {
    menuItem?.let {
      val adapter = MenuItemDetailsAdapter(it)
      val recyclerView = recyclerViewMenuItemDetails
      recyclerView.apply {
        recyclerView.adapter = adapter
        addItemDecoration(HeaderItemDecoration(recyclerView!!, false, isHeader()))
        layoutManager = LinearLayoutManager(this.context)
      }
    }

    // add action to floating action button
    textViewFloatingButton.setOnClickListener {

    }

  }

  private fun isHeader() : (itemPosition: Int) -> Boolean {
    return {
        itemPosition ->
      itemPosition == 0
    }
  }

  private fun setupToolBar() {
    val toolbar = toolbarMenuItemDetails
    toolbar.setNavigationOnClickListener {
      activity?.supportFragmentManager?.popBackStack()
    }
  }

  companion object {

    const val TAG = "MenuItemDetails"

    @JvmStatic
    fun newInstance(menuItem: MenuList) =
      MenuItemDetails().apply {
        arguments = Bundle().apply {
          putSerializable(ARG_MENU_ITEM, menuItem)
        }
      }
  }
}
