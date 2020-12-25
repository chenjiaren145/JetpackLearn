package com.example.jetpack.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.jetpack.data.ArchitectureRepository
import com.example.jetpack.room.Comment
import kotlinx.coroutines.launch

class ArchitectureViewModel @ViewModelInject constructor(
    private val architectureRepository: ArchitectureRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    val userName: MutableLiveData<String> by lazy {
        MutableLiveData("Jackson")
    }

    val comment: LiveData<Comment>? = architectureRepository.getCommentById(1)?.asLiveData()

    fun saveComment(commentStr: String) {
        viewModelScope.launch {
            architectureRepository.saveComment(Comment(1, commentStr))
        }

    }

    // ViewModel 销毁回调
    override fun onCleared() {
        super.onCleared()
    }

}