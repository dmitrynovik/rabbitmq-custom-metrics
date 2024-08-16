# RabbitMQ Custom Metrics Service and Dasboard

## What does it do?
* Polls metrics from [RabbitMQ HTTP API](https://www.rabbitmq.com/docs/management#http-api): `/api/queues`.
* For each queue, calculates queue usage vs. `max-length` or `max-length-bytes` policy if such policy exists.
* Logs the metrics into [Grafana Loki](https://grafana.com/oss/loki/).
* Shows a time series graph for each `vhost+queue` based on the above Loki data source.

NOTE: this example can be used for any other custom metrics

![architecture](/doc/architecture.png)

