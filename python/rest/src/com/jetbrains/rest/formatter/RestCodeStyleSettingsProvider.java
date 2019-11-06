// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.jetbrains.rest.formatter;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import com.jetbrains.rest.RestLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RestCodeStyleSettingsProvider extends CodeStyleSettingsProvider {
  @Nullable
  @Override
  public CustomCodeStyleSettings createCustomSettings(CodeStyleSettings settings) {
    return new RestCodeStyleSettings(settings);
  }

  @Nullable
  @Override
  public String getConfigurableDisplayName() {
    return "Rest";
  }

  @NotNull
  @Override
  public CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings, @NotNull CodeStyleSettings originalSettings) {
    return new CodeStyleAbstractConfigurable(settings, originalSettings, this.getConfigurableDisplayName()) {
      @Override
      protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
        return new TabbedLanguageCodeStylePanel(RestLanguage.INSTANCE, getCurrentSettings(), settings) {
          @Override
          protected void initTabs(CodeStyleSettings settings) {
            addIndentOptionsTab(settings);
          }
        };
      }
    };
  }
}
