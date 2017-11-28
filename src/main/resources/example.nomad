
job "example2" {
  datacenters = ["dc1"]
  type = "batch"
  group "cache" {
    count = 1

    task "hello" {
      driver = "exec"
      config {
        command = "java"
        args    = ["-version"]
      }
      resources {
        cpu    = 500 # 500 MHz
        memory = 256 # 256MB
      }
    }
  }
}