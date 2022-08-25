package com.felix.cryptoprice.ui.detail

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
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

        val symbol = args.symbol.toLowerCase()

        setUpObservers()
        detailViewModel.getInfo("$symbol")

        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }
    }

    private fun setUpObservers() {
        val progressDialog = ProgressDialog(requireContext())
        detailViewModel.detailResponse.observe(viewLifecycleOwner){
            when(it.status){
                Status.SUCCESS -> {
                    Glide.with(requireContext()).load(it.data?.body()?.data?.bTC?.logo).fitCenter().into(binding.ivPoster)
                    binding.tvDetailTitle.text = it.data?.body()?.data?.bTC?.name.toString()
                    binding.tvDescDetail.text = it.data?.body()?.data?.bTC?.description.toString()
                    binding.btnWeb.visibility = View.VISIBLE
                    binding.btnReddit.visibility = View.VISIBLE

//                    val web = it.data?.body()?.data?.bTC?.urls?.website
//                    val reddit = it.data?.body()?.data?.bTC?.urls?.reddit
//
//                    binding.btnWeb.setOnClickListener {
//                        val i = Intent(Intent.ACTION_VIEW, Uri.parse("$web"))
//                        startActivity(i)
//                    }
//                    binding.btnReddit.setOnClickListener {
//                        val i = Intent(Intent.ACTION_VIEW, Uri.parse("$reddit"))
//                        startActivity(i)
//                    }
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