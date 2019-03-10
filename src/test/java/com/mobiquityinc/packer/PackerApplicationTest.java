package com.mobiquityinc.packer;

import com.mobiquityinc.packer.exception.APIException;
import com.mobiquityinc.packer.model.Item;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Packer application tests
 *
 * @author serkaneren
 */
public class PackerApplicationTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private String filePath;

    @Before
    public void setup() {
        File resourcesDirectory = new File("src/test/resources");
        filePath = resourcesDirectory.getAbsolutePath();
    }

    @Test
    public void testFindPackageSuccess() throws APIException {
        String test = PackerApplication.pack(filePath +  "/testSuccess");
        assertEquals("4\n", test);
    }

    @Test
    public void testExcessiveWeightException() throws APIException {
        exception.expect(APIException.class);
        exception.expectMessage("Package can not be more than");
        PackerApplication.pack(filePath +  "/testExcessiveWeightException");
    }

    @Test
    public void testExcessiveAmountException() throws APIException {
        exception.expect(APIException.class);
        exception.expectMessage("Number of item can not be more than");
        PackerApplication.pack(filePath +  "/testExcessiveAmountException");
    }

    @Test
    public void testExcessiveItemWeightException() throws APIException {
        exception.expect(APIException.class);
        exception.expectMessage("Item weight can not be more than");
        PackerApplication.pack(filePath +  "/testExcessiveItemWeightException");
    }

    @Test
    public void testExcessiveItemPriceException() throws APIException {
        exception.expect(APIException.class);
        exception.expectMessage("Item price can not be more than");
        PackerApplication.pack(filePath +  "/testExcessiveItemPriceException");
    }
}
