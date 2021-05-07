/* **********************************************************
 * api-extension-template-vcloud-director
 * Copyright 2020-2021 VMware, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 * **********************************************************/

package com.vmware.vcloud.api.rest.client;

import java.text.MessageFormat;

/**
 * Bearer Token credentials suitable for use in authenticating with a vCD Appliance using the Cloud
 * Director Appliance API.
 *
 */
public final class ApplianceBearerLoginCredentials implements ClientCredentials {

    private final String bearerAuthenticationHeader;

    /**
     * Construct a {@link ApplianceBearerLoginCredentials} object using an OAuth Bearer token
     *
     * @param oAuthBearerToken
     *            Bearer Token supplied by the vcd appliance via the /sessions endpoint
     */
    public ApplianceBearerLoginCredentials(final String oAuthBearerToken) {
        bearerAuthenticationHeader =
                MessageFormat.format("Bearer {0}", oAuthBearerToken);
    }

    @Override
    public String getHeaderValue() {
        return bearerAuthenticationHeader;
    }

    @Override
    public String getHeaderName() {
        return "Authorization";
    }

    @Override
    public boolean supportsSessionless() {
        return true;
    }
}

