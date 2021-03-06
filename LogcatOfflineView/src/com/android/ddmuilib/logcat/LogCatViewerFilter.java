/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.ddmuilib.logcat;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.logcat.offline.view.ddmuilib.logcat.LogCatFilter;
import com.logcat.offline.view.ddmuilib.logcat.LogCatMessageWrapper;
import com.logcat.offline.view.ddmuilib.logcat.LogCatPanel;

/**
 * A JFace {@link ViewerFilter} for the {@link LogCatPanel} displaying logcat messages.
 * This is a simple wrapper around {@link LogCatFilter}.
 */
public final class LogCatViewerFilter extends ViewerFilter {
    private LogCatFilter mFilter;

    /**
     * Construct a {@link ViewerFilter} filtering logcat messages based on
     * user provided filter settings for PID, Tag and log level.
     * @param filter filter to use
     */
    public LogCatViewerFilter(LogCatFilter filter) {
        mFilter = filter;
    }

    @Override
    public boolean select(Viewer viewer, Object parent, Object element) {
        if (!(element instanceof LogCatMessageWrapper)) {
            return false;
        }

        LogCatMessage m = ((LogCatMessageWrapper) element).getLogCatMessage();
        return mFilter.matches(m);
    }
}
