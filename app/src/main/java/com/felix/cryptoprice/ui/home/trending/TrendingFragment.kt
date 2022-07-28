package com.felix.cryptoprice.ui.home.trending

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.felix.cryptoprice.R
import com.felix.cryptoprice.data.Status
import com.felix.cryptoprice.data.api.model.trending.GetTrendingLatestResponse
import com.felix.cryptoprice.databinding.FragmentTrendingBinding
import com.felix.cryptoprice.ui.base.BaseFragment
import com.felix.cryptoprice.ui.home.HomeFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrendingFragment : BaseFragment<FragmentTrendingBinding>(FragmentTrendingBinding::inflate) {

    private val trendingViewModel by viewModel<TrendingViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserver()
        trendingViewModel.getTrendingLatest()
    }

    private fun setupObserver() {
        val progressDialog = ProgressDialog(requireContext())
        trendingViewModel.trendingResponse.observe(viewLifecycleOwner){
            when (it.status){
                Status.LOADING -> {
                    progressDialog.setMessage("Loading...")
                    progressDialog.show()
                }
                Status.SUCCESS -> {
                    val adapter = TrendingAdapter(object  : TrendingAdapter.OnClickListener{
                        override fun onClickItem(data: GetTrendingLatestResponse.Data) {
                            val id = data.id
                            val actionToDetailFragment = HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
                            findNavController().navigate(actionToDetailFragment)
                        }
                    })
                    adapter.submitData(it.data?.body()?.data)
                    binding.rvTrending.adapter = adapter
                    progressDialog.dismiss()
                }
                Status.ERROR -> {
                    showSnackbar(it.message!!)
                }
            }
        }
    }
}