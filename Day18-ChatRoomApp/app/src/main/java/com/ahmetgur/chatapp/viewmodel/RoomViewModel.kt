package com.ahmetgur.chatapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmetgur.chatapp.Injection
import com.ahmetgur.chatapp.data.Result.*
import com.ahmetgur.chatapp.data.Room
import com.ahmetgur.chatapp.data.RoomRepository
import kotlinx.coroutines.launch

// liveData ile veri akışı sağlanır, MutableLiveData ile veri değişikliği yapılır,
// roomRepository ile veri akışı ve işlemleri sağlanır,
// viewModelScope ile işlemler yapılır
// tüm bunlar init bloğu içinde çağırılır (yani init bloğu içinde RoomRepository oluşturulur ve başlatılır)
class RoomViewModel: ViewModel() {

    private val _rooms = MutableLiveData<List<Room>>()
    val rooms: LiveData<List<Room>> get() = _rooms
    private val roomRepository: RoomRepository = RoomRepository(Injection.instance())

    init {
        loadRooms()
    }

    fun createRoom(name: String) {
        viewModelScope.launch {
            roomRepository.createRoom(name)
        }
    }


    fun loadRooms() {
        viewModelScope.launch {
            when (val result = roomRepository.getRooms()) {
                is Success -> result.data?.let { _rooms.value = it }
                is Error -> {
                    // Hata durumu
                }
            }
        }
    }

}

/*
            when (val result = roomRepository.getRooms()) {
                is Success -> _rooms.value = result.data
                is Error -> {

                }
            }
 */