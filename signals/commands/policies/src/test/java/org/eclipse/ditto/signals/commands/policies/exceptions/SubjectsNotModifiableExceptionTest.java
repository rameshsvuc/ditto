/*
 * Copyright (c) 2017 Bosch Software Innovations GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/epl-2.0/index.php
 *
 * Contributors:
 *    Bosch Software Innovations GmbH - initial contribution
 */
package org.eclipse.ditto.signals.commands.policies.exceptions;

import static org.eclipse.ditto.model.base.assertions.DittoBaseAssertions.assertThat;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;

import org.eclipse.ditto.json.JsonFactory;
import org.eclipse.ditto.json.JsonObject;
import org.eclipse.ditto.model.base.common.HttpStatusCode;
import org.eclipse.ditto.model.base.exceptions.DittoRuntimeException;
import org.eclipse.ditto.signals.commands.policies.TestConstants;
import org.junit.Test;

/**
 * Unit test for {@link SubjectsNotModifiableException}.
 */
public class SubjectsNotModifiableExceptionTest {

    private static final JsonObject KNOWN_JSON = JsonFactory.newObjectBuilder()
            .set(DittoRuntimeException.JsonFields.STATUS, HttpStatusCode.FORBIDDEN.toInt())
            .set(DittoRuntimeException.JsonFields.ERROR_CODE, SubjectsNotModifiableException.ERROR_CODE)
            .set(DittoRuntimeException.JsonFields.MESSAGE,
                    TestConstants.Policy.SUBJECTS_NOT_MODIFIABLE_EXCEPTION.getMessage())
            .set(DittoRuntimeException.JsonFields.DESCRIPTION,
                    TestConstants.Policy.SUBJECTS_NOT_MODIFIABLE_EXCEPTION.getDescription().get())
            .set(DittoRuntimeException.JsonFields.HREF,
                    TestConstants.Policy.SUBJECTS_NOT_MODIFIABLE_EXCEPTION.getHref().toString())
            .build();


    @Test
    public void assertImmutability() {
        assertInstancesOf(SubjectsNotModifiableException.class, areImmutable());
    }


    @Test
    public void checkSubjectsErrorCodeWorks() {
        final DittoRuntimeException actual =
                PolicyErrorRegistry.newInstance().parse(KNOWN_JSON, TestConstants.EMPTY_DITTO_HEADERS);

        assertThat(actual).isEqualTo(TestConstants.Policy.SUBJECTS_NOT_MODIFIABLE_EXCEPTION);
    }

}
