package com.gonzalez.blanchard.localdatasource.converters

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlin.reflect.KClass

abstract class BaseTypeConverter {

    fun <T : Any> getMoshiListAdapter(clazz: KClass<T>): JsonAdapter<List<T>> {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter(
                Types.newParameterizedType(
                    List::class.java,
                    clazz.java,
                ),
            )
    }

    fun <T : Any> getMoshiAdapter(clazz: KClass<T>): JsonAdapter<T> {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter(
                Types.newParameterizedType(
                    clazz.java,
                    String::class.java,
                ),
            )
    }
}
