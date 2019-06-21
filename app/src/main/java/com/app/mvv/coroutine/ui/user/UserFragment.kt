package com.app.mvv.coroutine.ui.user

import com.app.mvv.coroutine.R
import com.app.mvv.coroutine.base.BaseFragment
import com.app.mvv.coroutine.databinding.FragmentUserBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment<FragmentUserBinding, UserViewModel>() {
    private val userViewModel by viewModel<UserViewModel>()



    override fun getLayout(): Int {
        return R.layout.fragment_user
    }

    override fun getViewModel(): UserViewModel? {
        return userViewModel
    }
}