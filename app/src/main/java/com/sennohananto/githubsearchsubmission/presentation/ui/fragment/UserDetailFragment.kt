package com.sennohananto.githubsearchsubmission.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.sennohananto.githubsearchsubmission.presentation.viewmodel.UserDetailViewModel
import com.sennohananto.githubsearchsubmission.databinding.FragmentUserDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private lateinit var binding: FragmentUserDetailBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: UserDetailViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Assuming the username is passed as an argument
        val username = UserDetailFragmentArgs.fromBundle(
            requireArguments()
        ).username

        // Load user details
        viewModel.loadUserDetail(username)

        // Observe user details
        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            if (user != null) {
                binding.username.text = user.username
                binding.bio.text = user.bio
                Glide.with(this)
                    .load(user.avatarUrl)
                    .into(binding.avatar)
            }
        })
    }
}