package com.xxmukulxx.notes.feature_product.presentation.fragment

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.xxmukulxx.notes.R
import com.xxmukulxx.notes.common.BaseFragment
import com.xxmukulxx.notes.databinding.FragProductDisplayBinding
import com.xxmukulxx.notes.feature_product.presentation.vm.ProductDisplayViewModel
import com.xxmukulxx.notes.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetails(override val layoutResId: Int = R.layout.frag_product_display) :
    BaseFragment() {

    private lateinit var binding: FragProductDisplayBinding
    private val viewModel: ProductDisplayViewModel by viewModels()

    private val args: ProductDetailsArgs by navArgs()
    override fun onCreateView() {
        initBindingsAndViewModel()
        initViewModel()
        toast(args.toString())
    }

    private fun initViewModel() {
        viewModel.apply {
            b = binding
            setAppBar()
        }
    }

    private fun initBindingsAndViewModel() {
        binding = getBinding() as FragProductDisplayBinding
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }
}