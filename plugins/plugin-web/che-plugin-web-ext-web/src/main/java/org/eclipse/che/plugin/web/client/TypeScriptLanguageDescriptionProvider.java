/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.web.client;

import static java.util.Arrays.asList;

import javax.inject.Provider;
import org.eclipse.che.api.languageserver.shared.model.LanguageDescription;
import org.eclipse.che.plugin.web.shared.Constants;

public class TypeScriptLanguageDescriptionProvider implements Provider<LanguageDescription> {

  private static final String[] EXTENSIONS = new String[] {Constants.TS_EXT};
  private static final String MIME_TYPE = Constants.TS_MIME_TYPE;

  @Override
  public LanguageDescription get() {
    LanguageDescription description = new LanguageDescription();
    description.setFileExtensions(asList(EXTENSIONS));
    description.setLanguageId(Constants.TS_LANG);
    description.setMimeType(MIME_TYPE);
    description.setHighlightingConfiguration(
        "[\n"
            + "  {\"include\":\"orion.js\"},\n"
            + "  {\"match\":\"\\\\b(?:constructor|declare|module)\\\\b\",\"name\" :\"keyword.operator.typescript\"},\n"
            + "  {\"match\":\"\\\\b(?:any|boolean|number|string)\\\\b\",\"name\" : \"storage.type.typescript\"}\n"
            + "]");

    return description;
  }
}
