package com.gonzalez.blanchard.surveyapptest.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * Safe flow collector extension functions using API repeatOnLifecycle
 * @param [flow]
 * @param [state]
 * @param [body]
 * @return [Void]
 * @see <a href="https://tyris-sw.atlassian.net/l/cp/pkqru0GG">Confluence</a>
 *
 */

fun <T> LifecycleOwner.launchAndCollect(
    flow: Flow<T>,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    body: (T) -> Unit,
) {
    lifecycleScope.launch {
        repeatOnLifecycle(state) {
            flow.collect { body(it) }
        }
    }
}

/**
 * Safe flow collector extension functions using API flowWithLifecycle
 * @param [fragment]
 * @param [mainActiveState]
 * @param [action]
 * @return [Job]
 * @see <a href="https://tyris-sw.atlassian.net/l/cp/pkqru0GG">Confluence</a>
 *
 */

inline fun <reified T> Flow<T>.observeWithLifecycle(
    fragment: Fragment,
    mainActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    noinline action: suspend (T) -> Unit,
): Job = fragment.viewLifecycleOwner.lifecycleScope.launch {
    flowWithLifecycle(fragment.viewLifecycleOwner.lifecycle, mainActiveState).collect(action)
}

inline fun <reified T> Flow<T>.observeWithLifecycle(
    lifecycleOwner: LifecycleOwner,
    mainActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    noinline action: suspend (T) -> Unit,
): Job = lifecycleOwner.lifecycleScope.launch {
    flowWithLifecycle(lifecycleOwner.lifecycle, mainActiveState).collect(action)
}
