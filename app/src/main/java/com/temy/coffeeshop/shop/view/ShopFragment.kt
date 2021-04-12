package com.temy.coffeeshop.shop.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.temy.coffeeshop.R
import com.temy.coffeeshop.model.Product
import com.temy.coffeeshop.navigation.view.AppActivity
import com.temy.coffeeshop.navigation.view.HomeFragmentDirections
import com.temy.coffeeshop.shop.viewmodel.ShopViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment : Fragment() {

    private val viewModel by viewModels<ShopViewModelImpl>()

    private lateinit var adapter: ProductsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.productList.observe(viewLifecycleOwner, { onProductListChanged(it) })
        setupRecyclerView(view)
    }

    private fun onProductListChanged(list: List<Product>) {
        adapter.applyProductList(list)
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.shop_recycler_view)
        adapter = ProductsAdapter { product ->
            navigateToProductDetail(product)
        }
        recyclerView.adapter = adapter
    }

    private fun navigateToProductDetail(product: Product) {
        Navigation.findNavController(activity as AppActivity, R.id.splash_nav_host_fragment)
            .navigate(HomeFragmentDirections.actionToProductDetailsFragment(product))
    }
}