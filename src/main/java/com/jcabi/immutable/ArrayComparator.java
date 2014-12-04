/**
 * Copyright (c) 2012-2014, jcabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.immutable;

import com.jcabi.aspects.Immutable;
import java.io.Serializable;
import java.util.Comparator;

/**
 * Comparator for arrays.
 *
 * @param <T> Value type
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id$
 * @since 1.0
 */
@Immutable
@SuppressWarnings("unchecked")
public interface ArrayComparator<T> extends Comparator<T> {

    /**
     * Default comparator.
     * @param <T> Type of argument
     */
    @Immutable
    final class Default<T> implements ArrayComparator<T>, Serializable {
        /**
         * Serialization marker.
         */
        private static final long serialVersionUID = 0x54ef44fb3ef2efa3L;
        @Override
        public String toString() {
            return "DEFAULT";
        }
        @Override
        public int compare(final T left, final T right) {
            return ((Comparable<T>) left).compareTo(right);
        }
    }

    /**
     * Neutral comparator (never compares).
     * @param <T> Type of argument
     */
    @Immutable
    final class Neutral<T> implements ArrayComparator<T>, Serializable {
        /**
         * Serialization marker.
         */
        private static final long serialVersionUID = 0x54ef489b3ef2eca3L;
        @Override
        public String toString() {
            return "NEUTRAL";
        }
        @Override
        public int compare(final T left, final T right) {
            return 1;
        }
    }

    /**
     * Reverse comparator.
     * @param <T> Type of argument
     */
    @Immutable
    final class Reverse<T> implements ArrayComparator<T>, Serializable {
        /**
         * Serialization marker.
         */
        private static final long serialVersionUID = 0x545f489d3ed2eca3L;
        @Override
        public String toString() {
            return "REVERSE";
        }
        @Override
        public int compare(final T left, final T right) {
            return ((Comparable<T>) right).compareTo(left);
        }
    }

}