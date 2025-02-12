package com.guillermotoropavon.tastytrail.domain.repository

import com.guillermotoropavon.tastytrail.data.api.MealApiService
import com.guillermotoropavon.tastytrail.data.repository.RecipeRepositoryImpl
import com.guillermotoropavon.tastytrail.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRecipeRepository(
        recipeRepositoryImpl: RecipeRepositoryImpl
    ): RecipeRepository
}
