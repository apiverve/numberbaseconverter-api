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
        /// </summary>
        [JsonProperty("value")]
        public string Value { get; set; }

        /// <summary>
        /// Source base (default: 10)
        /// </summary>
        [JsonProperty("from")]
        public int? From { get; set; }

        /// <summary>
        /// Target base (returns all common bases if not specified)
        /// </summary>
        [JsonProperty("to")]
        public int? To { get; set; }
    }
}
