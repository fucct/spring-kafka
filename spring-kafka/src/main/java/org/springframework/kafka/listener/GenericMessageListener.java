/*
 * Copyright 2016-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.kafka.listener;

import org.apache.kafka.clients.consumer.Consumer;

import org.springframework.kafka.support.Acknowledgement;
import org.springframework.lang.Nullable;

/**
 * Top level interface for listeners.
 *
 * @param <T> the type received by the listener.
 *
 * @author Gary Russell
 * @since 1.1
 *
 */
@FunctionalInterface
public interface GenericMessageListener<T> {

	/**
	 * Invoked with data from kafka.
	 * @param data the data to be processed.
	 */
	void onMessage(T data);

	/**
	 * Invoked with data from kafka. The default implementation throws
	 * {@link UnsupportedOperationException}.
	 * @param data the data to be processed.
	 * @param acknowledgement the acknowledgement.
	 */
	default void onMessage(T data, @Nullable Acknowledgement acknowledgement) {
		throw new UnsupportedOperationException("Container should never call this");
	}

	/**
	 * Invoked with data from kafka and provides access to the {@link Consumer}. The
	 * default implementation throws {@link UnsupportedOperationException}.
	 * @param data the data to be processed.
	 * @param consumer the consumer.
	 * @since 2.0
	 */
	default void onMessage(T data, Consumer<?, ?> consumer) {
		throw new UnsupportedOperationException("Container should never call this");
	}

	/**
	 * Invoked with data from kafka and provides access to the {@link Consumer}. The
	 * default implementation throws {@link UnsupportedOperationException}.
	 * @param data the data to be processed.
	 * @param acknowledgement the acknowledgement.
	 * @param consumer the consumer.
	 * @since 2.0
	 */
	default void onMessage(T data, @Nullable Acknowledgement acknowledgement, Consumer<?, ?> consumer) {
		throw new UnsupportedOperationException("Container should never call this");
	}

}
