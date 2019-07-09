package com.app.mvv.coroutine.ui.user

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.mvv.coroutine.R
import com.app.mvv.coroutine.base.BaseFragment
import com.app.mvv.coroutine.databinding.FragmentUserBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment<FragmentUserBinding>() {
    private val userViewModel by viewModel<UserViewModel>()
    private val fragmentUserBinding:FragmentUserBinding? by lazy {
        viewDataBinding
    }



    override fun getLayout(): Int {
        return R.layout.fragment_user
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userViewModel.getUserData()
        fragmentUserBinding?.userRecyclerView?.apply {
            layoutManager= LinearLayoutManager(requireActivity())
            itemAnimator= DefaultItemAnimator()
            addItemDecoration(
                DividerItemDecoration(
                    fragmentUserBinding?.userRecyclerView?.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter=UserAdapter()
        }


    }


}