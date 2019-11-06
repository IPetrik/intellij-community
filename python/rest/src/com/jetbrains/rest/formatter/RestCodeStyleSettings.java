// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.jetbrains.rest.formatter;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class RestCodeStyleSettings extends CustomCodeStyleSettings {
  public RestCodeStyleSettings(CodeStyleSettings settings) {
    super("RestCodeStyleSettings", settings);
  }
}
