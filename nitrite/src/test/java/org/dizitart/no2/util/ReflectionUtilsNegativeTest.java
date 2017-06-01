/*
 * Copyright 2017 Nitrite author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dizitart.no2.util;

import org.dizitart.no2.exceptions.ValidationException;
import org.junit.Test;

import static org.dizitart.no2.util.ReflectionUtils.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Anindya Chatterjee.
 */
public class ReflectionUtilsNegativeTest {
    @Test(expected = ValidationException.class)
    public void testGetAnnotatedFieldsNullType() {
        assertEquals(getAnnotatedFields(null,
                Test.class).size(), 0);
    }

    @Test(expected = ValidationException.class)
    public void testGetAnnotatedFieldsNullAnnotation() {
        assertEquals(getAnnotatedFields(ClassWithNoAnnotatedFields.class,
                null).size(), 0);
    }

    @Test(expected = ValidationException.class)
    public void testGetFieldsUpToNullStartClass() {
        assertEquals(getFieldsUpTo(null, null).size(), 0);
    }

    @Test(expected = ValidationException.class)
    public void testGetFieldNoSuchField() {
        getField(getClass(), "test");
    }

    private static class ClassWithNoAnnotatedFields {
        private String stringValue;
        private Integer integer;
    }
}