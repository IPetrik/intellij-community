// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.jetbrains.rest.formatter

import com.intellij.application.options.IndentOptionsEditor
import com.intellij.application.options.SmartIndentOptionsEditor
import com.intellij.lang.Language
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider
import com.jetbrains.rest.RestLanguage

class RestLanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider() {
  private val SAMPLE =
    """=======================
reStructuredText parser
=======================

Introduction
------------

The intellij `reStructuredText (ReST) <http://docutils.sourceforge.net/rst.html>`_ parser is a basic ReST parser, developed for Python
development and Sphinx documentation.

Examples
--------

List
====

- An item
- An other item

  - Sub item that is a bit long, so
    maybe we want to wrap it?

- YA Item

Comment
=======

.. This is a comment
..
   _so: is this!
..
   [and] this!
..
   this:: too!
..
   |even| this:: !

Literal block
=============

Note:

::

   Literal block

   Content here

Other Note::

   Also a literal block

   With more text

Sphinx code
===========

.. code-block:: python
   :linenos:

   import logging

   logger = logging.getLogger(__name__)

   class MsgLogger(object):
       def __init__(self, msg: str):
           self.msg = msg

       def log(self):
           logger.info(self.msg)

   if __name__ == "__main__":
       helloLogger = MsgLogger("Hello, World!")

       helloLogger.log()
   
"""

  override fun getLanguage(): Language = RestLanguage.INSTANCE

  override fun getCodeSample(settingsType: SettingsType): String = SAMPLE

  override fun customizeDefaults(commonSettings: CommonCodeStyleSettings, indentOptions: CommonCodeStyleSettings.IndentOptions) {
    indentOptions.INDENT_SIZE = 3
    indentOptions.CONTINUATION_INDENT_SIZE = 3
    indentOptions.TAB_SIZE = 3
    indentOptions.KEEP_INDENTS_ON_EMPTY_LINES = true
  }

  override fun customizeSettings(consumer: CodeStyleSettingsCustomizable, settingsType: SettingsType) {}

  override fun getIndentOptionsEditor(): IndentOptionsEditor = SmartIndentOptionsEditor()

}
