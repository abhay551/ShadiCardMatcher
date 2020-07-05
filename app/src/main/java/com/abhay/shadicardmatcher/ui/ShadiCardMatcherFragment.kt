package com.abhay.shadicardmatcher.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.abhay.shadicardmatcher.R
import com.abhay.shadicardmatcher.base.BaseFragment
import com.abhay.shadicardmatcher.utils.RepositoryResult
import com.abhay.shadicardmatcher.data.model.ShadiCardMatcherModel
import kotlinx.android.synthetic.main.shadi_card_matcher_fragment.*
import java.util.*
import javax.inject.Inject

class ShadiCardMatcherFragment : BaseFragment(),
    ShadiCardMatcherAdapter.ShadiCardMatcherItemClickListener {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val shadiCardMatcherViewModel by viewModels<ShadiCardMatcherViewModel> { viewModelFactory }
    lateinit var shadiCardMatcherAdapter: ShadiCardMatcherAdapter
    lateinit var mContext: Context

    companion object {

        fun newInstance(): ShadiCardMatcherFragment {
            return ShadiCardMatcherFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.shadi_card_matcher_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shadiCardMatcherAdapter = ShadiCardMatcherAdapter(ArrayList(), mContext, this)
        view_pager.adapter = shadiCardMatcherAdapter

        shadiCardMatcherViewModel.users.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it.status) {
                RepositoryResult.Status.SUCCESS -> {
                    it.data?.let {
                        progress_loader.visibility = GONE
                        view_pager.visibility = VISIBLE
                        shadiCardMatcherAdapter.setItems(it)
                    }
                }
                RepositoryResult.Status.LOADING -> {
                    progress_loader.visibility = GONE
                    view_pager.visibility = VISIBLE
                }
                RepositoryResult.Status.ERROR
                -> {
                    progress_loader.visibility = GONE
                }
            }
        })
    }


    override fun onAcceptClick(shadiCardMatcherModel: ShadiCardMatcherModel) {
        shadiCardMatcherViewModel.onAccept(shadiCardMatcherModel)
    }

    override fun onRejectClick(shadiCardMatcherModel: ShadiCardMatcherModel) {
        shadiCardMatcherViewModel.onReject(shadiCardMatcherModel)
    }
}