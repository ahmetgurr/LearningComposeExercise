package com.ahmetgur.chatapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.ahmetgur.chatapp.Injection
import com.ahmetgur.chatapp.data.Message
import com.ahmetgur.chatapp.data.MessageRepository
import com.ahmetgur.chatapp.data.Result.*
import com.ahmetgur.chatapp.data.User
import com.ahmetgur.chatapp.data.UserRepository
import kotlinx.coroutines.launch

class MessageViewModel : ViewModel() {

    // mesajları ve kullanıcıyı almak için gerekli repository'ler
    private val messageRepository: MessageRepository
    private val userRepository: UserRepository
    init {
        messageRepository = MessageRepository(Injection.instance())
        userRepository = UserRepository(
            FirebaseAuth.getInstance(),
            Injection.instance()
        )
        loadCurrentUser()
    }

    // mesajları ve kullanıcıyı tutmak için gerekli livedata'lar / veri gösterimi için
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> get() = _messages

    private val _roomId = MutableLiveData<String>()
    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User> get() = _currentUser

    // loadCurrentUser: Sohbet sırasında her kullanıcı için bir kullanıcı nesnesi oluşturulur ve bu nesne _currentUser LiveData'sına atanır.
    private fun loadCurrentUser() {
        viewModelScope.launch {
            when (val result = userRepository.getCurrentUser()) {
                is Success -> _currentUser.value = result.data
                is Error -> {
                    // Handle error, e.g., show a snackbar
                }

            }
        }
    }

    fun loadMessages() {
        viewModelScope.launch {
            if (_roomId != null) {
                messageRepository.getChatMessages(_roomId.value.toString())
                    .collect { _messages.value = it }
            }
        }
    }

    fun sendMessage(text: String) {
        if (_currentUser.value != null) {
            val message = Message(
                senderFirstName = _currentUser.value!!.firstName,
                senderId = _currentUser.value!!.email,
                text = text
            )
            viewModelScope.launch {
                when (messageRepository.sendMessage(_roomId.value.toString(), message)) {
                    is Success -> Unit
                    is Error -> {

                    }
                }
            }
        }
    }

    fun setRoomId(roomId: String) {
        _roomId.value = roomId
        loadMessages()
    }






}