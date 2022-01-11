package com.xxmukulxx.notes.feature_product.presentation.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.xxmukulxx.notes.R
import com.xxmukulxx.notes.common.BaseFragment
import com.xxmukulxx.notes.databinding.FragAddProductBinding
import com.xxmukulxx.notes.feature_product.presentation.vm.ProductsViewModel
import com.xxmukulxx.notes.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddProduct(override val layoutResId: Int = R.layout.frag_add_product) : BaseFragment() {

    private lateinit var binding: FragAddProductBinding
    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreateView() {
        initBindingsAndViewModel()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.apply {
            b = binding
            setupItems()
            setAppBar()
        }

        viewModel.productList?.observe(requireActivity(), Observer {
            toast(it[0].title.toString())
        })

    }

    private fun initBindingsAndViewModel() {
        binding = getBinding() as FragAddProductBinding
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }
}