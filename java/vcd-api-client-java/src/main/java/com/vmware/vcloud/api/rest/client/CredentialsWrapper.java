/* **********************************************************
 * api-extension-template-vcloud-director
 * Copyright 2019-2021 VMware, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 * **********************************************************/

package com.vmware.vcloud.api.rest.client;

import java.util.Objects;

/**
 * Class that wraps a {@link ClientCredentials} implementation
 */
public class CredentialsWrapper implements ClientCredentials {

    private final ClientCredentials clientCredentials;

    /**
     * Construct credentials from a valid vCD organization qualified username  (username@orgname)
     * and a password.
     */
    public CredentialsWrapper(final ClientCredentials credentials) {
        Objects.requireNonNull(credentials, "credentials cannot be null");
        this.clientCredentials = credentials;
    }

    @Override
    public String getHeaderValue() {
        return clientCredentials.getHeaderValue();
    }

    @Override
    public String getHeaderName() {
        return clientCredentials.getHeaderName();
    }

    @Override
    public boolean supportsSessionless() {
        return clientCredentials.supportsSessionless();
    }

}

