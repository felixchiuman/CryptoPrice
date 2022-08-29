package com.felix.cryptoprice.ui.detail

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.felix.cryptoprice.R
import com.felix.cryptoprice.data.Status
import com.felix.cryptoprice.databinding.FragmentDetailBinding
import com.felix.cryptoprice.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val detailViewModel by viewModel<DetailViewModel>()

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val symbol = args.symbol

        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }

        setUpObservers()
        detailViewModel.getInfo("$symbol")
    }

    private fun setUpObservers() {
        val progressDialog = ProgressDialog(requireContext())
        detailViewModel.detailResponse.observe(viewLifecycleOwner){
            val symbol = args.symbol
            when(it.status){
                Status.SUCCESS -> {
                    Glide.with(requireContext()).load(it.data?.body()?.data?.get("$symbol")?.logo).fitCenter().into(binding.ivPoster)
                    binding.tvDetailTitle.text = it.data?.body()?.data?.get("$symbol")?.name
                    binding.tvDescDetail.text = it.data?.body()?.data?.get("$symbol")?.description

                    if (binding.tvDescDetail.text == "" || binding.tvDescDetail.text == "") {
                        detailViewModel.getInfo("$symbol")
                    }

                    val website = it.data?.body()?.data?.get("$symbol")?.urls?.website
                    val reddit = it.data?.body()?.data?.get("$symbol")?.urls?.reddit

                        if (website?.isNotEmpty() == true) {
                            val websiteValue = website?.get(0)
                            if (websiteValue != null) {
//                                if (websiteValue.isNotEmpty()){
                                    binding.btnWeb.visibility = View.VISIBLE
//                                }
                                binding.btnWeb.setOnClickListener {
                                    val i = Intent(Intent.ACTION_VIEW, Uri.parse("$websiteValue"))
                                    startActivity(i)
                                }
                            }
                        }
                        if (reddit?.isNotEmpty() == true) {
                            val redditValue = reddit?.get(0)
                            Log.d("reddit", "$redditValue")
                            if (redditValue != null) {
//                                if (redditValue.isNotEmpty()){
                                    binding.btnReddit.visibility = View.VISIBLE
//                                }
                                binding.btnWeb.setOnClickListener {
                                    val i = Intent(Intent.ACTION_VIEW, Uri.parse("$redditValue"))
                                    startActivity(i)
                                }
                            }
                        }

                    progressDialog.dismiss()
                }
                Status.ERROR -> {
                    showSnackbar(it.message!!)
                    progressDialog.dismiss()
                }
                Status.LOADING -> {
                    progressDialog.setMessage("Loading...")
                    progressDialog.show()
                }
            }
        }
    }
}