/*******************************************************************************
 * Copyright (c) 2012, 2015 Original authors and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Original authors and others - initial API and implementation
 ******************************************************************************/
package org.eclipse.nebula.widgets.nattable.data.convert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DefaultByteDisplayConverterTest {

    private DefaultByteDisplayConverter byteConverter = new DefaultByteDisplayConverter();

    @Test
    public void testNonNullDataToDisplay() {
        assertEquals("123", this.byteConverter.canonicalToDisplayValue(Byte.valueOf("123")));
    }

    @Test
    public void testNullDataToDisplay() {
        assertEquals(null, this.byteConverter.canonicalToDisplayValue(null));
    }

    @Test
    public void testNonNullDisplayToData() {
        assertEquals(Byte.valueOf("123"), this.byteConverter.displayToCanonicalValue("123"));
    }

    @Test
    public void testNullDisplayToData() {
        assertEquals(null, this.byteConverter.displayToCanonicalValue(""));
    }

    @Test(expected = ConversionFailedException.class)
    public void testConversionException() {
        this.byteConverter.displayToCanonicalValue("abc");
    }

    @Test(expected = ConversionFailedException.class)
    public void testConversionExceptionTooBig() {
        this.byteConverter.displayToCanonicalValue("129");
    }
}
