using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.NumberBaseConverter
{
    /// <summary>
    /// Query options for the Number Base Converter API
    /// </summary>
    public class NumberBaseConverterQueryOptions
    {
        /// <summary>
        /// The number to convert
        /// Example: FF
        /// </summary>
        [JsonProperty("value")]
        public string Value { get; set; }

        /// <summary>
        /// Source base (2-36, default: 10)
        /// Example: 16
        /// </summary>
        [JsonProperty("from")]
        public string From { get; set; }

        /// <summary>
        /// Target base (2-36, optional - returns all common bases if not specified)
        /// Example: 10
        /// </summary>
        [JsonProperty("to")]
        public string To { get; set; }
    }
}
