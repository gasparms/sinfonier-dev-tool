
#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
    The MIT License (MIT)

    Copyright (c) 2015 sinfonier-project

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.
"""


from apscheduler.schedulers.background import BackgroundScheduler
from collections import deque
import time
import basesinfonierspout
import json

class TestPySpout(basesinfonierspout.BaseSinfonierSpout):

    def __init__(self):

        basesinfonierspout.BaseSinfonierSpout().__init__()

    def useropen(self):

        # Using deque as a queue
        self.queue = deque()
        
        self.frequency = int(self.getParam("frequency"))
        
        # This scheduler launches self.job function every X seconds
        self.sched = BackgroundScheduler()
        self.sched.add_job(self.job, "interval", seconds=self.frequency, id="testpy")
        self.sched.start()

    def usernextTuple(self):

        # If there are items in self.queue, get the first one (.popleft()), do what you want with it and emit the tuple
        if self.queue:
            self.addField("timestamp",self.queue.popleft())
            self.emit()
    
    def userclose(self):
        
        pass
    
    def job(self):
        
        self.queue.append(str(int(time.time())))

TestPySpout().run()