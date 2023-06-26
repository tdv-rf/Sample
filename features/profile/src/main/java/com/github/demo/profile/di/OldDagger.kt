package com.github.demo.profile.di

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.demo.profile.ui.model.Random
import dagger.Component
import dagger.Subcomponent

@Component(
    modules = [ProfileSecondModule::class]
)
interface OldDaggerComponent {
    fun getBundle(): Bundle

    val oldDaggerSubComponentBuilder: OldDaggerSubComponent.Builder
}


@Subcomponent(
    modules = [ProfileModule::class]
)
interface OldDaggerSubComponent {

    fun getRandom(): Random

    @Subcomponent.Builder
    interface Builder {
        fun build(): OldDaggerSubComponent
    }
}

class MuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainComponent = DaggerOldDaggerComponent.create()
        val subComponent = mainComponent.oldDaggerSubComponentBuilder.build()

        val myRandom = subComponent.getRandom()

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}