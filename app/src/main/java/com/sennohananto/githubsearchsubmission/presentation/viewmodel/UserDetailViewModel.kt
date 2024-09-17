package com.sennohananto.githubsearchsubmission.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sennohananto.githubsearchsubmission.domain.usecase.GetUserDetailUseCase
import com.sennohananto.githubsearchsubmission.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getUserDetailUseCase: GetUserDetailUseCase
) : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user

    /**
     * Fetches the details of a user by username.
     *
     * @param username The username of the user to fetch.
     */
    fun loadUserDetail(username: String) {
        viewModelScope.launch {
            getUserDetailUseCase.execute(username).collect { result ->
                _user.value = result
            }
        }
    }
}