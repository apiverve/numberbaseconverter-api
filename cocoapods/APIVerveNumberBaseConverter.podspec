Pod::Spec.new do |s|
  s.name             = 'APIVerveNumberBaseConverter'
  s.version          = '1.2.3'
  s.summary          = 'Number Base Converter converts numbers between any base from 2 to 36, including binary, octal, decimal, and hexadecimal.'
  s.description      = <<-'DESC'
Number Base Converter converts numbers between any base from 2 to 36, including binary, octal, decimal, and hexadecimal. Pass a value with optional source and target bases to receive the converted string, base names, and exact decimal values.

This iOS/macOS SDK provides a convenient way to access the Number Base Converter from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/numberbaseconverter?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/numberbaseconverter-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveNumberBaseConverter/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
