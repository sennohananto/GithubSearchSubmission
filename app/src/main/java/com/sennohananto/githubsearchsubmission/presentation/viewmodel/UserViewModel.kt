package com.sennohananto.githubsearchsubmission.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sennohananto.githubsearchsubmission.domain.usecase.GetUserDetailUseCase
import com.sennohananto.githubsearchsubmission.domain.usecase.SearchUserUseCase
import com.sennohananto.githubsearchsubmission.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val searchUserUseCase: SearchUserUseCase,
    private val getUserDetailUseCase: GetUserDetailUseCase
) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user

    fun searchUsers(query: String) {
        viewModelScope.launch {
            searchUserUseCase.execute(query).collect { result ->
                _users.value = result
            }
        }
    }

    fun getUserDetail(username: String) {
        viewModelScope.launch {
            getUserDetailUseCase.execute(username).collect { result ->
                _user.value = result
            }
        }
    }
}