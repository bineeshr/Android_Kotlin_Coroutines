package com.app.mvv.coroutine.ui.user

import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mvv.coroutine.BR
import com.app.mvv.coroutine.R
import com.app.mvv.coroutine.base.BaseFragment
import com.app.mvv.coroutine.databinding.FragmentUserBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment<FragmentUserBinding,UserViewModel>() {
    private lateinit var userAdapter: UserAdapter
    override fun bindingVariable(): Int {
        return BR.viewModel
    }

    override fun layoutId(): Int {
        return R.layout.fragment_user
    }

    override fun viewModel(): UserViewModel {
        return userViewModel
    }

    private val userViewModel by viewModel<UserViewModel>()
    private val fragmentUserBinding:FragmentUserBinding? by lazy {
        viewDataBinding
    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userAdapter=UserAdapter()

        fragmentUserBinding?.userRecyclerView?.apply{
            val layoutManager=LinearLayoutManager(activity)
            layoutManager?.orientation = RecyclerView.VERTICAL
            this.layoutManager = layoutManager
           itemAnimator = DefaultItemAnimator()
            addItemDecoration(DividerItemDecoration(fragmentUserBinding?.userRecyclerView?.getContext(), DividerItemDecoration.VERTICAL))
            adapter = userAdapter
        }

        userViewModel.getUserData()

//        userViewModel.allGitUserResponse.observe(this, Observer {
//            userAdapter.clearData()
//            userAdapter.addAllUser(it)
//
//        })

    }


}