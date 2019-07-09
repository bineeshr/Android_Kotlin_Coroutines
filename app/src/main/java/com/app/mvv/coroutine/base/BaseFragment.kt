package com.app.mvv.coroutine.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding,V:BaseViewModel> : Fragment() {
    var viewDataBinding: T? = null
    private var mViewModel: V? = null

    abstract fun bindingVariable(): Int
    abstract fun layoutId(): Int
    abstract fun viewModel(): V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return viewDataBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel=viewModel()
        viewDataBinding?.let {
            it.setVariable(bindingVariable(), mViewModel)
            it.executePendingBindings()
            it.lifecycleOwner = this
        }
    }


}